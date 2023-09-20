# ForceLanguage
Forcibly replace the body of a patch request with alternate content.

This extension, compatible with Burp Suite Enterprise Edition, replaces the body of a `PATCH` request containing the regular expression `"language":"[a-z]+"` with `"language":"en"`.

## Usage
- Build extension/download release JAR
- [Load extension into Enterprise](https://portswigger.net/burp/documentation/enterprise/bapps-and-custom-extensions/adding-extensions#adding-a-custom-extension-to-burp-suite-enterprise-edition)
- [Apply to the relevant site](https://portswigger.net/burp/documentation/enterprise/bapps-and-custom-extensions/scanning-with-extensions)

You should test whether this extension is fit for purpose in Burp Suite Professional before use in Burp Suite Enterprise Edition.
