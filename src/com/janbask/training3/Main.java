package com.janbask.training3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        SimpleConfiguration simpleConfiguration = (SimpleConfiguration) context.getBean("simpleConfiguration");
        DownloaderBase downloader = (DownloaderBase) context.getBean("downloader");
        Logger logger = (Logger) context.getBean("logger");
        logger.Log("Started ClassPathXmlApplicationContext loading...");
        logger.Log("ClassPathXmlApplicationContext loaded!");
        logger.Log("Loading download configuration...");
        logger.Log("download configuration loaded!");
        logger.Log(String.format("Configuration\n****\nUrl: %s\nFile Prefix: %s\n****", simpleConfiguration.getDownloadUrl(), simpleConfiguration.getFileNamePrefix()));
        logger.Log("starting download...");
        downloader.downloadFile(simpleConfiguration, logger);
        logger.Log("download finished!");
    }
}
