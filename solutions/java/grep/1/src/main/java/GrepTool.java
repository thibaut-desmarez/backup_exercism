import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

class GrepTool {

    String grep(String pattern, List<String> flags, List<String> files) {
        StringBuilder result = new StringBuilder();
        try {
            for (String file : files) {
                List<String> lines = Files.readAllLines(Paths.get(file));
                if(files.size()>1){
                    for (int i = 0; i < lines.size(); i++) {
                        String line = lines.get(i);
                        if (!flags.contains("-v")) {
                            if (!flags.contains("-x")) {
                                if (!flags.contains("-i") && line.contains(pattern)) {
                                    if (flags.contains("-l")) {
                                        result.append(file).append("\n");
                                        break;
                                    } else {
                                        result.append(file).append(":").append(addLine(line, flags, i));
                                    }
                                } else if (flags.contains("-i") && line.toLowerCase().contains(pattern.toLowerCase())) {
                                    result.append(file).append(":").append(addLine(line, flags, i));
                                }

                            } else {
                                if (!flags.contains("-i") && line.equals(pattern)) {
                                    if (flags.contains("-l")) {
                                        result.append(file).append("\n");
                                        break;
                                    } else {
                                        result.append(file).append(":").append(addLine(line, flags, i));
                                    }
                                } else {
                                    if (line.equalsIgnoreCase(pattern)) {
                                        result.append(file).append(":").append(addLine(line, flags, i));
                                    }
                                }
                            }
                        } else {
                            if (!line.contains(pattern)) {
                                result.append(file).append(":").append(addLine(line, flags, i));
                            }
                        }
                    }
                }
                else {
                    for (int i = 0; i < lines.size(); i++) {
                        String line = lines.get(i);
                        if (!flags.contains("-v")) {
                            if (!flags.contains("-x")) {
                                if (!flags.contains("-i") && line.contains(pattern)) {
                                    if (flags.contains("-l")) {
                                        result.append(file).append("\n");
                                        break;
                                    } else {
                                        result.append(addLine(line, flags, i));
                                    }
                                } else {
                                    if (line.toLowerCase().contains(pattern.toLowerCase())) {
                                        result.append(addLine(line, flags, i));
                                    }
                                }
                            } else {
                                if (!flags.contains("-i") && line.equals(pattern)) {
                                    if (flags.contains("-l")) {
                                        result.append(file).append("\n");
                                        break;
                                    } else {
                                        result.append(addLine(line, flags, i));
                                    }
                                } else {
                                    if (line.equalsIgnoreCase(pattern)) {
                                        result.append(addLine(line, flags, i));
                                    }
                                }
                            }
                        } else {
                            if (!line.contains(pattern)) {
                                result.append(addLine(line, flags, i));
                            }
                        }
                    }
                }
            }
            if (result.length() > 2) {
                result.delete(result.length() - 1, result.length()); //delete last \n
            }
            return result.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    String addLine(String line, List<String> flags, int lineNumber) {
        StringBuilder result = new StringBuilder();
        if(flags.contains("-n")){
            result.append(lineNumber+1).append(":").append(line);
        }
        else{
            result.append(line);
        }
        result.append("\n");
        return result.toString();
    }
    
}