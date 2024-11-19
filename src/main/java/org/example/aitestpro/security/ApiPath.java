package org.example.aitestpro.security;

public class ApiPath {
    public ApiPath() {
    }

    public enum GetApi {

        HEALTH_CHECK("/ping"),
        SWAGGER_API_V2_DOCS("/v2/api-docs"),
        SWAGGER_RESOURCE_CONFIGURATION("/swagger-resources/configuration/ui"),
        SWAGGER_RESOURCES("/swagger-resources"),
        SWAGGER_RESOURCES_SECURITY_CONFIGURATION("/swagger-resources/configuration/security"),
        SWAGGER_UI_HTML("swagger-ui.html"),
        SWAGGER_UI("/swagger-ui/**"),//swagger-ui/index.html
        SWAGGER_API_V3_DOCS("/v3/api-docs/**"),
        SWAGGER_CONFIGURATION("/configuration/**"),
        SWAGGER("/swagger*/**");

        private final String path;

        public String getPath() {
            return path;
        }

        GetApi(String path) {
            this.path = path;
        }
    }

    public  enum  PostAPi{
        REGISTER("/auth/register"),
        LOGIN("/auth/login");
        private String path;
        PostAPi(String path) {
            this.path = path;
        }
        public String getPath() {
            return path;
        }
    }
}
