package lod;

class NetworkTransporter {
    public Byte[] send(String address, Byte[] data) {}
}


public class HtmlDownloader {
    private NetworkTransporter transporter;

    // HtmlDownloader这里也要有相应的修改
    public Html downloadHtml(String url) {
        HtmlRequest htmlRequest = new HtmlRequest(url);
        Byte[] rawHtml = transporter.send(
                htmlRequest.getAddress(), htmlRequest.getContent().getBytes());
        return new Html(rawHtml);
    }
}

class Document {
    private Html html;
    private String url;

    public Document(String url, Html html) {
        this.url = url;
        this.html = html;
    }
}

// Use factory method to create Document
class DocumentFactory {
    private HtmlDownloader downloader;

    public DocumentFactory(HtmlDownloader downloader) {
        this.downloader = downloader;
    }

    public Document createDocument(String url) {
        Html html = downloader.downloadHtml(url);
        return new Document(url, html);
    }
}