class Url {
    private String URL;

    private Url() {
        //NO-OP
    }

    public String getURL() {
        return URL;
    }

    //A builder is probably a bit overkill here but when the URL gets more complicated bit could be useful
    public static class UrlBuilder {
        private final String BASE_URL = "https://api.spotify.com";
        private final String API_VERSION = "/v1";

        //TODO Add more components when API is understood
        private String URL;
        private String searchTerms;

        public UrlBuilder() {
            this.URL = BASE_URL + API_VERSION;
        }

        public UrlBuilder addSearchTerm(String searchTerms) {
            //TODO consider making this a list for more complex searches?
            this.searchTerms = searchTerms;
            return this;
        }

        public Url build() {
            Url url = new Url();
            url.URL = URL;
            return url;
        }
    }
}
