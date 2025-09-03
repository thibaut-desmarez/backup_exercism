class RnaTranscription {
    String transcribe(String dnaStrand) {
        if(dnaStrand == null || dnaStrand.isBlank()){return "";}
        StringBuilder rna = new StringBuilder();
        for(int i = 0; i < dnaStrand.length(); i++){
            if(dnaStrand.charAt(i) == 'C'){rna.append("G");}
            else if(dnaStrand.charAt(i) == 'G'){rna.append("C");}
            else if(dnaStrand.charAt(i) == 'T'){rna.append("A"); }
            else if(dnaStrand.charAt(i) == 'A'){rna.append("U");}
        }
        return rna.toString();
    }
}
