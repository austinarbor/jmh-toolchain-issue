package dev.aga;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

public class StringReplacerBenchmark {

    @Benchmark
    public void ReplaceAll(StateHolder sh, Blackhole bh) {
        String result = StringReplacer.replaceAll(sh.source, sh.pat, sh.repl);
        bh.consume(sh);
    }

    @State(Scope.Benchmark)
    public static class StateHolder {
        private String source;
        private String replace;
        private String pat;
        private String repl;

        @Setup(Level.Trial)
        public void setup() {
            this.source = "abcdefghi";
            this.pat = "def";
            this.repl = "";
        }
    }
}
