package shiv.analyzer;

import org.jgrapht.Graph;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import shiv.Analyzer;
import shiv.RelayEdge;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class RecursiveDependencyAnalyzer implements Analyzer {

    @Override
    public Optional<Exception> analyze(Graph<Class<?>, RelayEdge> graph) {

        var kot = new KosarajuStrongConnectivityInspector<>(graph);

        var sets = kot.getStronglyConnectedComponents();

        List<Set<RelayEdge>> cycles = kot
                .getStronglyConnectedComponents()
                .stream()
                .map(Graph::edgeSet)
                .filter(set -> set.size() > 0)
                .toList();

        StringBuilder builder = new StringBuilder("[Shiv/RecursiveDependency] ")
                .append("\n\nError: Shiv detected recursive dependencies (B depends on A depends on B) in your project!");

        int counter = 0;

        for (Set<RelayEdge> cycle : cycles) {
            counter++;

            for (RelayEdge edge : cycle) {
                builder
                        .append("\n\t")
                        .append("[").append(edge.source()).append("]")
                        .append(" -> ")
                        .append("[").append(edge.target()).append("]");
            }

            builder.append("\n");
        }

        builder.append("\nDetected ").append(counter).append(" cycles. Please make it so that your dependencies do not create a loop.");

        if (counter == 0) {
            return Optional.empty();
        }


        return Optional.of(new RecursiveDependencyException(builder.toString()));
    }
}
