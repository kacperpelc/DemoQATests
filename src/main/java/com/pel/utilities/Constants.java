package com.pel.utilities;

import java.io.File;

public class Constants {
    public static final String DEMOQA_URL = "https://demoqa.com";

    public static final String ATTACHMENTS_DIR = String.format(System.getProperty("user.dir") + "%ssrc%smain%sresources%sattachments%s",
            File.separator, File.separator, File.separator, File.separator, File.separator);
    public static final String DOWNLOADS_DIR = String.format(System.getProperty("user.dir") + "%starget%sdownloads%s",
            File.separator, File.separator, File.separator);
    public static final String SCREENSHOTS = System.getProperty("user.dir") + "/target/screenshots/";


    public static final int TIMEOUT_VERY_HIGH = 60;
    public static final int TIMEOUT_HIGH = 30;
    public static final int TIMEOUT_MEDIUM_HIGH = 15;
    public static final int TIMEOUT_MEDIUM = 10;
    public static final int TIMEOUT_LOW = 5;
    public static final int TIMEOUT_VERY_LOW = 2;
}
