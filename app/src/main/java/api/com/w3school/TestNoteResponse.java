package api.com.w3school;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name = "note")
public class TestNoteResponse {
    @Element(name = "to")
    public String to;
    @Element(name = "from")
    public String from;
    @Element(name = "heading")
    public String heading;
    @Element(name = "body")
    public String body;
}
