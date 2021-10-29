package lod;

// NetworkTransporter as a low level common class, should not depend on
// HtmlRequest, can just depend on address and data
public class NetworkTransporter {
    public Byte[] send(HtmlRequest htmlRequest) {
        //...
    }
}

public class HtmlDownloader {
    private NetworkTransporter transporter;

    public Html downloadHtml(String url) {
        Byte[] rawHtml = transporter.send(new HtmlRequest(url));
        return new Html(rawHtml);
    }
}

class Document {
    private Html html;
    private String url;

    public Document(String url) {
        this.url = url;
        HtmlDownloader downloader = new HtmlDownloader();
        this.html = downloader.downloadHtml(url);
    }
    //...
}