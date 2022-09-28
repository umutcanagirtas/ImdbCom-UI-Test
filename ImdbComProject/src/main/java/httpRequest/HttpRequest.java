package httpRequest;

import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class HttpRequest {
    public static List<String> httpRequestForLinks(List<WebElement> photoLinks){
        List<String> brokenLinks=new ArrayList<>();
        String url ;
        HttpURLConnection huc;
        int respCode;
        for (WebElement link : photoLinks) {
            url = link.getAttribute("href");
            System.out.println(url);
            if (url == null || url.isEmpty()) {
                System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());
                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();
                if (respCode >= 400) {
                    brokenLinks.add(url);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return brokenLinks;
    }
}
