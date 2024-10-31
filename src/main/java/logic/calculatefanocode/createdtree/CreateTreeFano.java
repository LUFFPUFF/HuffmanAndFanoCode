package logic.calculatefanocode.createdtree;

import logic.calculatefanocode.calculate.CalculateFanoCode;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.view.mxGraph;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class CreateTreeFano {

    public static void create(Map<String, String> fanoCodes, String filePath) {
        Graph<String, DefaultEdge> graph = new SimpleWeightedGraph<>(DefaultEdge.class);

        String root = "Слияние: ";
        graph.addVertex(root);

        for (Map.Entry<String, String> entry : fanoCodes.entrySet()) {
            String symbol = entry.getKey();
            String code = entry.getValue();

            String current = root;
            for (char bit : code.toCharArray()) {
                String next = current + bit;

                if (!graph.containsVertex(next)) {
                    graph.addVertex(next);
                }

                if (!graph.containsEdge(current, next)) {
                    graph.addEdge(current, next);
                }
                current = next;
            }

            String symbolNode = symbol + ": " + code;
            graph.addVertex(symbolNode);
            graph.addEdge(current, symbolNode);
        }

        mxGraph mxGraph = new mxGraph();
        Object parent = mxGraph.getDefaultParent();

        mxGraph.getModel().beginUpdate();
        try {
            Map<String, Object> vertexMap = new HashMap<>();
            for (String vertex : graph.vertexSet()) {
                vertexMap.put(vertex, mxGraph.insertVertex(parent, null, vertex, 100, 100, 80, 30));
            }

            for (DefaultEdge edge : graph.edgeSet()) {
                mxGraph.insertEdge(parent, null, null, vertexMap.get(graph.getEdgeSource(edge)), vertexMap.get(graph.getEdgeTarget(edge)));
            }
        } finally {
            mxGraph.getModel().endUpdate();
        }

        mxGraphComponent graphComponent = new mxGraphComponent(mxGraph);
        mxIGraphLayout layout = new mxHierarchicalLayout(mxGraph);
        layout.execute(parent);

        JFrame frame = new JFrame("Shannon-Fano Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphComponent);
        frame.setSize(1000, 800);
        frame.setVisible(true);

        saveGraphAsImage(graphComponent, filePath);
    }

    private static void saveGraphAsImage(mxGraphComponent graphComponent, String filePath) {
        BufferedImage image = new BufferedImage(graphComponent.getWidth(), graphComponent.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        graphComponent.paint(g);
        g.dispose();

        try {
            ImageIO.write(image, "png", new File(filePath));
            System.out.println("Graph saved as " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
