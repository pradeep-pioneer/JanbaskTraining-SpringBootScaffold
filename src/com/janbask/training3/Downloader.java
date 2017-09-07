package com.janbask.training3;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Downloader implements DownloaderBase{

    public void downloadFile(SimpleConfiguration configuration, Logger logger){
        BufferedInputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            logger.Log("opening HTTP stream...");
            inputStream = new BufferedInputStream(new URL(configuration.getDownloadUrl()).openStream());
            String fileName = String.format(configuration.getFileNamePrefix(), new Date());
            logger.Log(String.format("opening file output stream to file %s...", fileName));
            fileOutputStream = new FileOutputStream(fileName);
            byte data[] = new byte[1024];
            int count;
            int totalBytes=0;
            logger.Log(String.format("reading HTTP stream to file %s...", fileName));
            while ((count = inputStream.read(data, 0, 1024)) != -1) {
                fileOutputStream.write(data, 0, count);
                totalBytes+=count;
                logger.Log(String.format("read bytes: %s", count));
            }
            logger.Log("finished reading!");
            logger.Log(String.format("total bytes downloaded: %s", totalBytes));
            logger.Log(String.format("file downloaded [%s]",fileName));
        }catch (MalformedURLException exception){
            System.out.println("Invalid Url!");
        }catch (IOException exception){
            exception.printStackTrace();
        }finally {
            try {
                if (inputStream != null)
                    inputStream.close();
                if(fileOutputStream!=null)
                    fileOutputStream.close();
            }catch (Exception exception){
                exception.printStackTrace();
            }
        }
    }
}
