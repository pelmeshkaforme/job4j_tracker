package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] words, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(key)) {
                rsl = i;
                return rsl;
            }
        }
        if (rsl == -1) {
            throw new ElementNotFoundException("Element not detected.");
        }
        return rsl;
    }

    public static boolean send(String value, String[] abuses) throws ElementAbuseException {
        boolean rsl = true;
        for (int i = 0; i < abuses.length; i++) {
            if (abuses[i].equals(value)) {
                rsl = false;
                throw new ElementAbuseException("Element from abuse list");
            }
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] words = {"Table", "Chair", "Window", "Sky"};
        String[] abuses = {"Sky"};
        try {
            indexOf(words, "Sky");
            send("Sky", abuses);
        } catch (ElementAbuseException ea) {
            ea.printStackTrace();
        } catch (ElementNotFoundException en) {
            en.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
