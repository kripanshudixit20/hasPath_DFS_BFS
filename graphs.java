import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class graphs
{
    private Boolean hasPathDFS(String src, String dest, HashMap<String, String[]> graph)
    {
        if (src.equals(dest)) return true;
        else
        {
            if (src.equals("")) return false;
            for (String node : graph.get(src))
            {
                if (hasPathDFS(node, dest, graph)) return true;
            }
        }
        return false;
    }

    private Boolean hasPathBFS(String src, String dest, HashMap<String, String[]> graph)
    {
        Queue<String> queue = new LinkedList<>();
        queue.add(src);
        while (queue.size() > 0)
        {
            if (queue.peek().equals(dest)) return true;
            else
            {
                String current = queue.remove();
                if (dest.equals(current)) return true;
                for (String node : graph.get(current))
                {
                    if (!(node.equals(""))) queue.add(node);
                }
            }
        }

        return false;
    }

    public static void main(String...args)
    {
        graphs ob = new graphs();
        HashMap<String, String[]> graph = new HashMap<>();

        graph.put("f", new String[]{"g", "i"});
        graph.put("g", new String[]{"h"});
        graph.put("h", new String[]{""});
        graph.put("i", new String[]{"g", "k"});
        graph.put("j", new String[]{"i"});
        graph.put("k", new String[]{""});
        System.out.println(ob.hasPathDFS("f", "j", graph));
        System.out.println(ob.hasPathBFS("f", "j", graph));
    }
}
