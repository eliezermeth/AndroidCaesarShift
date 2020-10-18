package com.mindtedtech.androidcaesarshift;

/**
 * @author Eliezer Meth
 * Start Date: 2020-10-18
 *
 * Class to perform Caesar Shift on input text (only letters).
 * Code copied and modified from previous program (CaesarCipher)
 */
public class CaesarShift
{
    // Class variables
    StringBuilder sb;

    /**
     * Constructor.
     * @param text Text to have shift performed on.
     * @param letterShift Int of amount to be shifted.
     */
    public CaesarShift(String text, int letterShift)
    {
        sb = new StringBuilder(text);
        letterShift = letterShift % 26; // bring to single alphabet

        for (int i = 0; i < sb.length(); i++)
        {
            if (Character.isLetter(sb.charAt(i)))
            {
                char letter = sb.charAt(i);
                // A = 65; Z = 90; a = 97; z = 122
                if (Character.isUpperCase(letter))
                {
                    int letterNum = (int) letter % 65; // make A = 0
                    if (letterNum + letterShift > 25) // past Z
                    {
                        sb.setCharAt(i, (char) (letter + letterShift - 25));
                    }
                    else if (letterNum + letterShift < 0) // before A
                    {
                        sb.setCharAt(i, (char) (91 - (letterShift - letterNum))); // backwards from Z
                    }
                    else // does not wrap around alphabet
                    {
                        sb.setCharAt(i, (char) (letter + letterShift));
                    }
                }
                else if (Character.isLowerCase(letter)) // can it just be else?
                {
                    int letterNum = (int) letter % 97; // make a = 0
                    if (letterNum + letterShift > 25) // past z
                    {
                        sb.setCharAt(i, (char) (letter + letterShift - 25));
                    }
                    else if (letterNum + letterShift < 0) // before a
                    {
                        sb.setCharAt(i, (char) (123 - (letterShift - letterNum))); // backwards from z
                    }
                    else // does not wrap around alphabet
                    {
                        sb.setCharAt(i, (char) (letter + letterShift));
                    }
                }
            }
        }
    }

    /**
     * Method to get shifted text.
     * @return String of shifted text.
     */
    public String getText()
    {
        return sb.toString();
    }
}
