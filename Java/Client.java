import java.io.*;
import java.net.*;

public class Client {

    /**
     * This method name and parameters must remain as-is
     */
    public static int add(int lhs, int rhs) {
        //client marshals the call parameters into a wire-friendly format
        RemoteMethod add = new RemoteMethod("add", new Object[]{lhs, rhs}, new Object[]{-1});

        //client connects to the server
        try(Socket socket = new Socket("localhost", 10314)) {
            try (
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);) {
            
                oos.writeObject(add);
                oos.flush();

                //client receives the marshaled result data
                //client unmarshals the result data
                try(InputStream fis = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(fis);) {
                    RemoteMethod obj = (RemoteMethod) ois.readObject();

                    Object[] results = obj.getResult();
        
                    return (Integer)results[0];
                } catch (Exception err) {
                    err.printStackTrace();
                }

            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception err) {
            System.out.println("The server is not running, in order to run the program please start the server.");
        }

        return -1;
    }
    /**
     * This method name and parameters must remain as-is
     */
    public static int divide(int num, int denom) {
        //client marshals the call parameters into a wire-friendly format
        RemoteMethod divide = new RemoteMethod("divide", new Object[]{num, denom}, new Object[]{-1});

        //client connects to the server
        try(Socket socket = new Socket("localhost", 10314)) {
            try (
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);) {
            
                oos.writeObject(divide);
                oos.flush();

                //client receives the marshaled result data
                //client unmarshals the result data
                try(InputStream fis = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(fis);) {
                    RemoteMethod obj = (RemoteMethod) ois.readObject();

                    Object[] results = obj.getResult();

                    return (Integer)results[0];
                } catch (Exception err) {
                    err.printStackTrace();
                }

            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception err) {
            System.out.println("The server is not running, in order to run the program please start the server.");
        }

        return -1;
    }
    /**
     * This method name and parameters must remain as-is
     */
    public static String echo(String message) {
        //client marshals the call parameters into a wire-friendly format
        RemoteMethod echo = new RemoteMethod("echo", new Object[]{message}, new Object[]{""});

        //client connects to the server
        try(Socket socket = new Socket("localhost", 10314)) {
            try (
            OutputStream os = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);) {
            
                oos.writeObject(echo);
                oos.flush();

                //client receives the marshaled result data
                //client unmarshals the result data
                try(InputStream fis = socket.getInputStream();
                ObjectInputStream ois = new ObjectInputStream(fis);) {
                    RemoteMethod obj = (RemoteMethod) ois.readObject();

                    Object[] results = obj.getResult();

                    return (String)results[0];
                } catch (Exception err) {
                    err.printStackTrace();
                }

            } catch(IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception err) {
            System.out.println("The server is not running, in order to run the program please start the server.");
        }

        return "";
    }

    // Do not modify any code below this line
    // --------------------------------------
    String server = "localhost";
    public static final int PORT = 10314;

    public static void main(String... args) {
        // All of the code below this line must be uncommented
        // to be successfully graded.
        System.out.print("Testing... ");

        if (add(2, 4) == 6)
            System.out.print(".");
        else
            System.out.print("X");

        try {
            divide(1, 0);
            System.out.print("X");
        }
        catch (ArithmeticException x) {
            System.out.print(".");
        }

        if (echo("Hello").equals("You said Hello!"))
            System.out.print(".");
        else
            System.out.print("X");
        
        System.out.println(" Finished");
    }
}