class Url {
    private String URL;

    private Url() {
        //NO-OP
    }

    public String getURL() {
        return URL;
    }

    //A builder is probably a bit overkill here but when the URL gets more complicated, it could be useful.
    //How I build the strings could be better
    public static class UrlBuilder {
        private String url;
        private final String BASE_URL = "https://api.spotify.com";
        private final String API_VERSION = "/v1";

        private final String ALBUM = "/albums";
        private final String SEARCH = "/search?";

        UrlBuilder() {
            this.url = BASE_URL + API_VERSION;
        }

        //General Search
        UrlBuilder search(String queryString) {
            url = url + SEARCH + queryString;
            return this;
        }

        //Album Related Methods
        UrlBuilder getAlbum(String albumId, boolean tracks) {
            url = url + ALBUM  + "/" + albumId;
            if (tracks) url = url + "/tracks";
            return this;
        }

        UrlBuilder getAlbums(String albumIds) {
            url = url + ALBUM  + "/?ids=" + albumIds;
            return this;
        }

        Url build() {
            Url url = new Url();
            url.URL = this.url;
            return url;
        }
    }
}
