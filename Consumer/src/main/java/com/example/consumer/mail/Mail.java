package com.example.consumer.mail;

import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;

public class Mail {
    public  String generateMail(String name, String message) throws RemoteException {
        String finishedMail="";

        finishedMail = String.format("Dear valued customer %s. We are happy to inform you that we have received your feedback (%s). And will be processing it within the next 48 hours. Thank you for your time!", name, message);

        try {
            FileWriter myWriter = new FileWriter(String.format("Mail sent to %s", name));
            myWriter.write(finishedMail);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return finishedMail;
    }
}
