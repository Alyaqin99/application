package newApplication;
import java.io.File;
import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
//import static javafx.application.Platform.exit;
    public class Application {
           public static void main(String[] args) throws IOException {
             Scanner scan = new Scanner(System.in); 
             int  choice;
             int selection ;
              System.out.println("Welcome to LockedMe Application\nDeveloped by: Alyaqin Alyahay\nE-mail:218011046@student.kfu.edu.sa\n----------------------");
              do {
                  System.out.println("1. List files in a directory");
                  System.out.println("2. file manipulation");
                   System.out.println("3. exit");
                  System.out.println("choose any one : ");
                  selection = scan.nextInt();
                   System.out.println("-------------------------");
                  switch (selection){
                      case 1:
                      {
                          Scanner scanner = new Scanner( System.in );
                      System.out.println("Enter the file path: ");
                      String dirPath = scanner.nextLine(); // Takes the directory path as the user input
                    File folder = new File(dirPath);
                    if(folder.isDirectory())
                    {
                        File[] fileList = folder.listFiles();
                        Arrays.sort(fileList);
                        Arrays.sort(fileList);
                        System.out.println("\nTotal number of items present in the directory: " + fileList.length );
                        // Lists only files since we have applied file filter
                        for(File file:fileList)
                        {
                            System.out.println(file.getName());
                        }
                        // Creating a filter to return only files.
                        FileFilter fileFilter = new FileFilter()
                        {
                            @Override
                            public boolean accept(File file) {
                                return !file.isDirectory();
                            }
                        };
                        fileList = folder.listFiles(fileFilter);
                        // Sort files by name
                        Arrays.sort(fileList, new Comparator()
                        {
                            @Override
                            public int compare(Object f1, Object f2) {
                                return ((File) f1).getName().compareTo(((File) f2).getName());
                            }
                        });
                              }
                        System.out.println("-------------------------");
                          }
                      break ;
                      case 2:
                      {
                          do {
                          System.out.println("1. add File");
            System.out.println("2. delete File");
            System.out.println("3. search File");
            System.out.println("4. back");
            System.out.println("Choose any one : ");
            choice = scan.nextInt(); 
               System.out.println("-------------------------");                          
            switch(choice) {
               case 1:
                {
                   try{
                    System.out.println("Enter file name: ");
                      Scanner scanner = new Scanner( System.in );
                      String fname = scanner.nextLine();
                       //String path = "C:\\Users\\sa2017\\Documents\\yqn"+fname;
                    File f = new File(fname);
                    if(!f.exists())
                    {
                        f.createNewFile();
                        System.out.println("File got created");
                    }else {
                        System.out.println("File existed ! ");                       
                    }                   
                   }catch (IOException e){
                        e.printStackTrace();  
                        }                                       
                   System.out.println("-------------------------");
                }
                break;
                case 2:
                {
                    try{
                    System.out.println("Enter file name to delete it: ");
                      Scanner scanner = new Scanner( System.in );
                      String fname = scanner.nextLine();
                      File f = new File(fname);                     
                      if(f.exists()){
                          f.delete();
                          System.out.println("File deleted successfully ");
                      }else {
                          System.out.println("File not found !!");
                      }
                    }catch (Exception e){
                        e.printStackTrace();  
                        }                     
                   System.out.println("-------------------------");                                           
                }
                break;
                case 3:
                {
                FindFile ff = new FindFile();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the file to be searched.. " );
        String name = sc.next();
        System.out.println("Enter the directory where to search ");
        String directory = sc.next();
        ff.findFile(name,new File(directory));
                }
                break;
                case 4:{break ;}                
                default: 
                    System.out.println("Wrong choice !!");
                  // code block
                      }}while (choice != 4);                          
                      break; 
                          }            
                      case 3:
                      {break ;
                      }                  
              }
              }while (selection != 3 );       
             }  
        }