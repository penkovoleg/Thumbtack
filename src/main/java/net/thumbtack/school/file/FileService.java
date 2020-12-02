package net.thumbtack.school.file;

import com.google.gson.Gson;
import net.thumbtack.school.colors.v3.ColorException;
import net.thumbtack.school.figures.v3.ColoredRectangle;
import net.thumbtack.school.figures.v3.Rectangle;
import net.thumbtack.school.ttschool.Trainee;
import net.thumbtack.school.ttschool.TrainingException;

import java.io.*;
import java.util.Scanner;

public class FileService {

    public static void writeByteArrayToBinaryFile(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFile(File file, byte[] array) throws IOException {
        try(FileOutputStream fos = new FileOutputStream(file);){
            fos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFile(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFile(File file) throws IOException {
        try(FileInputStream fis = new FileInputStream(file);){
            return fis.readAllBytes();
        }
    }

    public static byte[] writeAndReadByteArrayUsingByteStream(byte[] array) throws IOException {
        byte[] byteArray;
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            baos.writeBytes(array);
            byteArray = baos.toByteArray();
        }

        byte[] arrayInput = new byte[array.length / 2];
        try(ByteArrayInputStream bais = new ByteArrayInputStream(byteArray)){
            for(int i = 0, a = 0; i < array.length; i++){
                if(i % 2 == 0) {
                    arrayInput[a] = (byte) bais.read();
                    a++;
                }
                else bais.read();
            }
        }
        return arrayInput;
    }

    public static void writeByteArrayToBinaryFileBuffered(String fileName, byte[] array) throws IOException {
        writeByteArrayToBinaryFile(new File(fileName), array);
    }

    public static void writeByteArrayToBinaryFileBuffered(File file, byte[] array) throws IOException {
        try(BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file))){
            fos.write(array);
        }
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(String fileName) throws IOException {
        return readByteArrayFromBinaryFile(new File(fileName));
    }

    public static byte[] readByteArrayFromBinaryFileBuffered(File file) throws IOException {
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))){
            return bis.readAllBytes();
        }
    }

    public static void writeRectangleToBinaryFile(File file, Rectangle rect) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromBinaryFile(File file) throws IOException {
        try(DataInputStream dis = new DataInputStream(new FileInputStream(file))){
            return new Rectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt());
        }
    }

    public static void writeColoredRectangleToBinaryFile(File file, ColoredRectangle rect) throws IOException {
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            dos.writeInt(rect.getTopLeft().getX());
            dos.writeInt(rect.getTopLeft().getY());
            dos.writeInt(rect.getBottomRight().getX());
            dos.writeInt(rect.getBottomRight().getY());
            dos.writeUTF(rect.getColor().toString());
        }
    }

    public static ColoredRectangle readColoredRectangleFromBinaryFile(File file) throws IOException, ColorException {
        try(DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            return new ColoredRectangle(dis.readInt(), dis.readInt(), dis.readInt(), dis.readInt(), dis.readUTF());
        }
    }

    public static void writeRectangleArrayToBinaryFile(File file, Rectangle[] rects) throws IOException{
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))){
            for (Rectangle rect : rects) {
                dos.writeInt(rect.getTopLeft().getX());
                dos.writeInt(rect.getTopLeft().getY());
                dos.writeInt(rect.getBottomRight().getX());
                dos.writeInt(rect.getBottomRight().getY());
            }
        }
    }

    public static Rectangle[] readRectangleArrayFromBinaryFileReverse(File file) throws IOException{
        Rectangle[] rects = new Rectangle[(int) (file.length() / 16)];
        try(RandomAccessFile raf = new RandomAccessFile(file, "r")){
            for (int i = 0; i < rects.length; i++) {
                raf.seek((rects.length - 1 - i) * 16);
                rects[i] = new Rectangle(raf.readInt(), raf.readInt(), raf.readInt(), raf.readInt());
            }
        }
        return rects;
    }

    public static void writeRectangleToTextFileOneLine(File file, Rectangle rect) throws IOException{
        try (PrintWriter pw = new PrintWriter(file)){
            pw.format("%d %d %d %d", rect.getTopLeft().getX(), rect.getTopLeft().getY(), rect.getBottomRight().getX(), rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileOneLine(File file) throws IOException{
        Rectangle rect = null;
        try (Scanner sc = new Scanner(new FileReader(file))) {
            while (sc.hasNext()){
                rect = new Rectangle(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
            }
        }
        return rect;
    }

    public static void writeRectangleToTextFileFourLines(File file, Rectangle rect) throws IOException{
        try (PrintWriter pw = new PrintWriter(file)){
            pw.format("%d\n %d\n %d\n %d", rect.getTopLeft().getX(), rect.getTopLeft().getY(), rect.getBottomRight().getX(), rect.getBottomRight().getY());
        }
    }

    public static Rectangle readRectangleFromTextFileFourLines(File file) throws IOException {
        return readRectangleFromTextFileOneLine(file);
    }

    public static void writeTraineeToTextFileOneLine(File file, Trainee trainee) throws IOException{
        try(PrintWriter pw = new PrintWriter(file, "UTF-8")){
            pw.format("%s %s %d", trainee.getFirstName(), trainee.getLastName(), trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileOneLine(File file) throws IOException, TrainingException{
        Trainee trainee = null;
        try (Scanner sc = new Scanner(new FileReader(file))) {
            while (sc.hasNext()){
                trainee = new Trainee(sc.next(), sc.next(), sc.nextInt());
            }
        }
        return trainee;
    }

    public static void writeTraineeToTextFileThreeLines(File file, Trainee trainee) throws IOException {
        try (PrintWriter pw = new PrintWriter(file)){
            pw.format("%s\n %s\n %d", trainee.getFirstName(), trainee.getLastName(), trainee.getRating());
        }
    }

    public static Trainee readTraineeFromTextFileThreeLines(File file) throws IOException, TrainingException {
        return readTraineeFromTextFileOneLine(file);
    }

    public static void serializeTraineeToBinaryFile(File file, Trainee trainee) throws IOException{
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(trainee);
        }
    }

    public static Trainee deserializeTraineeFromBinaryFile(File file) throws IOException, ClassNotFoundException{
        Trainee trainee;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            trainee = (Trainee)ois.readObject();
        }
        return trainee;
    }

    public static String serializeTraineeToJsonString(Trainee trainee){
        return new Gson().toJson(trainee);
    }

    public static Trainee deserializeTraineeFromJsonString(String json){
        return new Gson().fromJson(json, Trainee.class);
    }

    public static void serializeTraineeToJsonFile(File file, Trainee trainee) throws IOException{
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            new Gson().toJson(trainee, bw);
        }
    }

    public static Trainee deserializeTraineeFromJsonFile(File file) throws IOException{
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            return new Gson().fromJson(br, Trainee.class);
        }
    }

}
