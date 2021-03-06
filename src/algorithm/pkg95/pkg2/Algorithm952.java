// added this comment just for test

//New comment 
//Newer comment as guest
//Next comment 
//added this comment for another test!

//my new comment with MyNewBranch

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithm.pkg95.pkg2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * 
 */
public class Algorithm952 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input = new Scanner(System.in);
        // **********************************
        System.out.println("************      Menu      ************** \n Plz Enter One of the Menu Numbers");
        System.out.println("1. Exit \n2. Generate File\n3. Merge Sort \n4. etc");
        while(true)
        {
            int n = input.nextInt();
            switch (n)
            {
                case 1:
                    Exit(); // don't forget to use comment in your code.
                    break;
                case 2:
                    System.out.println("Generating random integers and writing to File.txt ...");
                    generateFile();
                    break;
                case 3:
                    System.out.println("Using Merge Sort Method For Sorting.");
                    //voroodi mikhad!! az generateFile bayad estefade konam??
                    //mergeSort();
                    break;
            }
        }
        
    }
    
    public static int[] getArray()
    {
        // Ali Salehi - 9250025
        // it returns an array read from a file
        int []array;
        try
        {
            InputStream fis = new FileInputStream("File.txt");
            InputStreamReader isr = new InputStreamReader(fis, Charset.forName("UTF-8"));
            BufferedReader br = new BufferedReader(isr);
            List<Integer> arr = new ArrayList<Integer>();
            String line;
            // read from file and split by ',' then store the integer in an array List
            while(( line = br.readLine()) != null)
            {
                String []ss = line.split(",");
                for(int i=0;i<ss.length;i++)
                {
                    arr.add(Integer.parseInt(ss[i]));
                }
            }
            // call the Convert Integer method. it converts a list to an array
            array  = convertIntegers(arr);
            //System.out.println("array.length >    " + array.length);
            return array;
        }
        catch(Exception ex)
        {
            System.out.println("Exception :   " +ex);
        }
        array = new int[0];
        return array;
    }
    public static int[] convertIntegers(List<Integer> integer)
    {
        // this Method Convert an Integer ArrayList to integer array :)
        int []result = new int[integer.size()];
        for(int i=0;i< result.length;i++)
            result[i] = integer.get(i).intValue();
        return result;
    }
    public static void Exit()
    {
        /*  Ali Salehi - 9250025
            Run time for this function >> very low
            <the student must write the exact time for their functions>
            <if your fuction takes more than 30 min to compelete, stop the program and write more than 30 min>
        */
        System.out.println("Exit called");
        System.exit(0);
        
        /*
            at this place other student check the function and write down their result. for example:
            Ali Salehi - 9250025{
                run time >> 0.1 sec (or very low)
                how did I optimal the code?
                    >> first
                    >>second
                    >>etc
            }
        */
    }
    
    
    public static void generateFile()
    {
        /*  Mohammad Amin Meshk - 9450025
            Mansour Ahmadzadeh - 9450001
            Run time for this function: < 1 second
        */
        try
        {
            long FirstTime = System.currentTimeMillis();
            Random rand = new Random();
            File file = new File("File.txt");
            FileWriter wr = new FileWriter(file);
            wr.append(1 + ",");
            int count = 6580000;
            for (int i = 0; i < count; i++)
            {
                wr.append(rand.nextInt(998) + 1 + ",");
            }
            wr.append(999 + "");
            wr.flush();
            wr.close();
            long FinalTime = System.currentTimeMillis();
            System.out.println("The File.txt has been successfully generated with the size of " + file.length() / 1000 +
                    " KB and " + count + " integer numbers and took " + (FinalTime - FirstTime) + " miliseconds.");

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
    
    public static int[] mergeSort(int a[])
    {
        /*  Iman Shirali - 9450016
            Mohammad Hassan Helali Jula- 
            Amirhossein Salahmanesh- 9450035
            Run time for this function:-------
        */
	if(a.length<=1){
            return a;
	}

	int b[];
	int c[];
	int x=a.length;
        
	if(x%2==0){
            b=new int[(a.length/2)];
            c=new int[(a.length/2)];

	}
        else{
            b=new int[(a.length/2)];
            c=new int[(a.length/2)+1];
	}
		
	for(int i=0 ;i<b.length ;i++){
            b[i]=a[i];
	}
		
	for(int i=b.length;i<a.length ;i++){
            c[i-b.length]=a[i];
	}
			
	b=mergeSort(b);
	c=mergeSort(c);
	return merge(b,c);
        
    }
	
    public static int[] merge(int b[],int c[])
    {
	/*  Iman Shirali - 9450016
            Mohammad Hassan Helali- 
            Amirhossein Salahmanesh- 9450035
        */	
	int res[]=new int[b.length+c.length];
	int i=0,j=0,k=0;
	while(i<b.length && j<c.length){
            if(b[i]>c[j]){
		res[k]=c[j];
		j++;
            }
            else{
		res[k]=b[i];
		i++;
            }
            k++;
            }
            if(i==b.length){
		while(j<c.length){
		res[k]=c[j];
		j++;
		k++;
                }
            }
            else if(j==c.length){
                while(i<b.length){
                    res[k]=b[i];
                    i++;
                    k++;
		}
            }
	return res;
    }
    
}
