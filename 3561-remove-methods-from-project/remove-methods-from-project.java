class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] inv : invocations) adj.get(inv[0]).add(inv[1]);

        // Step 1: find all "suspicious" methods reachable from k
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(k);
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (int nxt : adj.get(cur)) {
                if (!suspicious[nxt]) {
                    suspicious[nxt] = true;
                    stack.push(nxt);
                }
            }
        }

        // Step 2: if any non-suspicious method calls into the suspicious group, removal is impossible
        for (int[] inv : invocations) {
            if (suspicious[inv[1]] && !suspicious[inv[0]]) {
                List<Integer> all = new ArrayList<>();
                for (int i = 0; i < n; i++) all.add(i);
                return all;
            }
        }

        // Step 3: otherwise remove the suspicious methods
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!suspicious[i]) result.add(i);
        }
        return result;
    }
}