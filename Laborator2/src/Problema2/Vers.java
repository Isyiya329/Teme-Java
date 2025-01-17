package Problema2;

public class Vers
{
    private String text;

    public Vers(String text) {
        this.text = text;
    }

    public int numarCuvinte() {
        if (text.trim().isEmpty()) {
            return 0;
        }
        return text.trim().split("\\s+").length;
    }

    public int numarVocale() {
        int count = 0;
        String lowerCaseText = text.toLowerCase();
        for (char c : lowerCaseText.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                count++;
            }
        }
        return count;
    }

    public boolean seTerminaCu(String grupare) {
        return text.endsWith(grupare);
    }

    public void toUpperCase() {
        this.text = this.text.toUpperCase();
    }

    public String getText() {
        return text;
    }

}
