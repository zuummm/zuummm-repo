package org.ave.pet.coin;

public class StringInSwitch {
    
    public String getSpeciesByVoice(final String voice) {
        String species = null;
        if (voice != null) { 
            switch (voice.toLowerCase()) {
            case "meow": case "nyau": case "miau":
                species = "cat";
                break;
            case "bark": case "vau": case "wuff":
                species = "dog";
                break;
            default:
                species = "unknown";
            }
        }
        return species;
    }

}
