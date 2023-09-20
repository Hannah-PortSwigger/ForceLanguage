import burp.api.montoya.BurpExtension;
import burp.api.montoya.MontoyaApi;
import burp.api.montoya.http.handler.*;
import burp.api.montoya.http.message.requests.HttpRequest;

import java.util.Objects;

public class ForceLanguage implements BurpExtension
{
    @Override
    public void initialize(MontoyaApi api)
    {
        api.extension().setName("Force language");

        api.http().registerHttpHandler(new HttpHandler()
        {
            @Override
            public RequestToBeSentAction handleHttpRequestToBeSent(HttpRequestToBeSent requestToBeSent)
            {
                if (Objects.equals(requestToBeSent.method(), "PATCH"))
                {
                    String newBody = requestToBeSent.bodyToString().replaceAll("\"language\":\"[a-z]+\"", "\"language\":\"en\"");
                    HttpRequest finalRequest = requestToBeSent.withBody(newBody);

                    return RequestToBeSentAction.continueWith(finalRequest);
                }

                return RequestToBeSentAction.continueWith(requestToBeSent);
            }

            @Override
            public ResponseReceivedAction handleHttpResponseReceived(HttpResponseReceived responseReceived)
            {
                return ResponseReceivedAction.continueWith(responseReceived);
            }
        });
    }
}