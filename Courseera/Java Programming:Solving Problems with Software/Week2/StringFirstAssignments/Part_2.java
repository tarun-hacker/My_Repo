/*

Problem Statement:
1.  The method findSimpleGene has one parameter for the DNA string named dna. Modify findSimpleGene to add two additional parameters, one named startCodon for the start 
    codon and one named stopCodon for the stop codon. What additional changes do you need to make for the program to compile? After making all changes, run your program to check that you get the same output as before.

2.  Modify the findSimpleGene method to work with DNA strings that are either all uppercase letters such as “ATGGGTTAAGTC” or all lowercase letters such as “gatgctataat”. 
    Calling findSimpleGene with “ATGGGTTAAGTC” should return the answer with uppercase letters, the gene “ATGGGTTAA”, and calling findSimpleGene with “gatgctataat” should return the answer with lowercase letters,
    the gene “atgctataa”. HINT: there are two string methods toUpperCase() and toLowerCase(). If dna is the string “ATGTAA” then dna.toLowerCase() results in the string “atgtaa”.
*/
public class Part_2
{
    private String findSimpleGene(String dna,String startCodon,String stopCodon)
    {
        String result = "";
        int startPos = 0;
        int endPos = 0;
        if(isLower(dna))
        {
            startPos = dna.indexOf(startCodon.toLowerCase());
            if(startPos > 0)
            {
                endPos = dna.indexOf(stopCodon.toLowerCase(), startPos + startCodon.length());
                if(endPos > 0)
                {
                    if(dna.substring(startPos+startCodon.length(),endPos).length()%3==0)
                    {
                        result = dna.substring(startPos,endPos + stopCodon.length());
                    }
                }
            }
        }
        else
        {
            startPos = dna.indexOf(startCodon.toUpperCase());
            if(startPos > 0)
            {
                endPos = dna.indexOf(stopCodon.toUpperCase(), startPos + startCodon.length());
                if(endPos > 0)
                {
                    if(dna.substring(startPos+startCodon.length(),endPos).length()%3==0)
                    {
                        result = dna.substring(startPos,endPos + stopCodon.length());
                    }
                }
            }
        }
        return result;
    }
    public void testSimpleGene()
    {
        String firstTestCase = "AAATTGTATCCATTAA";
        String secondTestCase = "TTTTAAACGATTTCCGATG";
        String thirdTestCase = "TTTTTTTTAAAAAAGGGGGGGTCGTA";
        String fourthTestCase = "TAAGTTTAGATGTTTAGTTAAATGTTTTAGCTT";
        String fifthTestCase = "ATGTTTTTGCCCTTTTTAATTTTGC";
        String sixthTestCase = "gatgctataat";
        String startCodon = "ATG";
        String stopCodon = "TAA";
        System.out.println("DNA String: " + firstTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(firstTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + secondTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(secondTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + thirdTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(thirdTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + fourthTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(fourthTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + fifthTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(fifthTestCase,startCodon,stopCodon));
        System.out.println("DNA String: " + sixthTestCase);
        System.out.println("Simple Gene: " + findSimpleGene(sixthTestCase,startCodon,stopCodon));
    }
}