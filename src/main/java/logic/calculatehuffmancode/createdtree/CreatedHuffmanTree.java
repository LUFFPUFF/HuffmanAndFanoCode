package logic.calculatehuffmancode.createdtree;

import logic.calculatehuffmancode.calculate.CalculateHuffmanCode;
import logic.calculatehuffmancode.config.ConfigHuffmanCode;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.swing.mxGraphComponent;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultDirectedWeightedGraph;
import org.jgrapht.graph.DefaultWeightedEdge;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreatedHuffmanTree {

    public static void create(String path) {
        Graph<String, DefaultWeightedEdge> graph = new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
        buildGraph(ConfigHuffmanCode.root, graph, null, "");

        mxGraphComponent graphComponent = displayGraph(graph);

        saveGraphAsImage(graphComponent, path);
    }

    private static void buildGraph(CalculateHuffmanCode.Node node, Graph<String, DefaultWeightedEdge> graph, String parent, String edgeLabel) {
        if (node == null) return;

        String nodeLabel = node.data != null ? node.data + " (" + String.format("%.3f", node.frequency) + ")"
                : String.format("%.3f", node.frequency);
        graph.addVertex(nodeLabel);

        if (parent != null) {
            DefaultWeightedEdge edge = graph.addEdge(parent, nodeLabel);
            if (edge != null) {
                graph.setEdgeWeight(edge, edgeLabel.equals("0") ? 0 : 1);
            }
        }

        buildGraph(node.left, graph, nodeLabel, "0");
        buildGraph(node.right, graph, nodeLabel, "1");
    }

    private static mxGraphComponent displayGraph(Graph<String, DefaultWeightedEdge> graph) {
        mxGraphComponent graphComponent = createGraphComponent(graph);
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(graphComponent);
        frame.setSize(800, 800);
        frame.setVisible(true);
        return graphComponent;
    }

    public static mxGraphComponent createGraphComponent(Graph<String, DefaultWeightedEdge> graph) {
        com.mxgraph.view.mxGraph jGraphX = new com.mxgraph.view.mxGraph();
        Object parent = jGraphX.getDefaultParent();

        jGraphX.getModel().beginUpdate();
        try {
            Map<String, Object> vertexMap = new HashMap<>();
            for (String vertex : graph.vertexSet()) {
                vertexMap.put(vertex, jGraphX.insertVertex(parent, null, vertex, 0, 0, 80, 40));
            }
            for (DefaultWeightedEdge edge : graph.edgeSet()) {
                String source = graph.getEdgeSource(edge);
                String target = graph.getEdgeTarget(edge);
                String label = String.valueOf((int) graph.getEdgeWeight(edge));
                jGraphX.insertEdge(parent, null, label, vertexMap.get(source), vertexMap.get(target));
            }
        } finally {
            jGraphX.getModel().endUpdate();
        }

        mxHierarchicalLayout layout = new mxHierarchicalLayout(jGraphX);
        layout.setOrientation(SwingConstants.NORTH);
        layout.execute(jGraphX.getDefaultParent());

        return new mxGraphComponent(jGraphX);
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
