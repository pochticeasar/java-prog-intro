package markup;

import java.util.*;

public interface actions {
    void toMarkdown(StringBuilder out);
    void toBBCode(StringBuilder out);
}