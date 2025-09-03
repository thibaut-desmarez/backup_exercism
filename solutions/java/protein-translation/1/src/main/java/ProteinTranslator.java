import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ProteinTranslator {

    HashMap<List<String>, String> linkedCodonsToAminoAcid = populateLinkedCodonsToAminoAcid();

    List<String> translate(String rnaSequence) {
        List<String> result = new ArrayList<>();

        for(int i = 0; i < rnaSequence.length(); i+=3) {
            if(i > rnaSequence.length()-3){
                throw new IllegalArgumentException("Invalid codon");
            }
            String aminoAcid = findAminoAcidFromCodon(rnaSequence.substring(i, i+3));
            if(aminoAcid.equals("STOP")) {
                return result;
            }
            result.add(aminoAcid);
        }
        if(result.isEmpty() && rnaSequence.length()%3 != 0) {
            throw new IllegalArgumentException("Invalid codon");
        }
        return result;
    }

    HashMap<List<String>, String> populateLinkedCodonsToAminoAcid(){
        HashMap<List<String>, String> result = new HashMap<>();
        result.put(List.of("AUG"),"Methionine");
        result.put(List.of("UUU", "UUC"),"Phenylalanine");
        result.put(List.of("UUA", "UUG"),"Leucine");
        result.put(List.of("UCU", "UCC", "UCA", "UCG"),"Serine");
        result.put(List.of("UAU", "UAC"),"Tyrosine");
        result.put(List.of("UGU", "UGC"),"Cysteine");
        result.put(List.of("UGG"),"Tryptophan");
        result.put(List.of("UAA", "UAG", "UGA"),"STOP");
        return result;
    }

    String findAminoAcidFromCodon(String codon) {
        try {
            List<String> result = linkedCodonsToAminoAcid.keySet().stream()
                    .filter(list -> list.contains(codon))
                    .findFirst()
                    .orElseThrow(IllegalArgumentException::new);
            return linkedCodonsToAminoAcid.get(result);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Invalid codon");
        }
    }
}
