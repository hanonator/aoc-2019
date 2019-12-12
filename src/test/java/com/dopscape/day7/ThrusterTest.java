package com.dopscape.day7;

import org.junit.jupiter.api.Test;

public class ThrusterTest {

    @Test
    public void test() {
//        int[] memory = {3,8,1001,8,10,8,105,1,0,0,21,34,51,64,73,98,179,260,341,422,99999,3,9,102,4,9,9,1001,9,4,9,4,9,99,3,9,1001,9,4,9,1002,9,3,9,1001,9,5,9,4,9,99,3,9,101,5,9,9,102,5,9,9,4,9,99,3,9,101,5,9,9,4,9,99,3,9,1002,9,5,9,1001,9,3,9,102,2,9,9,101,5,9,9,1002,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,101,1,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,101,1,9,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,101,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,1,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,99,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,102,2,9,9,4,9,3,9,102,2,9,9,4,9,3,9,101,2,9,9,4,9,3,9,1001,9,2,9,4,9,99,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,3,9,1001,9,1,9,4,9,3,9,101,1,9,9,4,9,3,9,102,2,9,9,4,9,3,9,1001,9,2,9,4,9,3,9,1002,9,2,9,4,9,3,9,1001,9,2,9,4,9,99
//        };
//
//        List<String> possible_arguments = permutations("", "01234", 5);
//        int highest = 0;
//        for (String possible : possible_arguments) {
//
//            Deque<Integer> input = new ArrayDeque<>(List.of(0));
//            Deque<Integer> manual_input = toDeque(possible);
//
//            Memory m = new ArrayMemory(memory);
//            Processor processor = new Processor(m, new DefaultInstructionSet(input::poll, input::addFirst));
//
//            for (int i = 0; i < 5; i++) {
//                input.addFirst(manual_input.poll());
//                processor.process();
//
//                if (input.peek() >= highest) {
//                    highest = input.peek();
//                }
//            }
//
//        }
//
//        System.out.println(highest);
    }
//    public List<String> permutations(String prefix, String str, int k) {
//        if (prefix.length() == k) {
//            return Collections.singletonList(prefix);
//        }
//        List<String> results = new ArrayList<>();
//        for (int i = 0; i < str.length(); i++) {
//            results.addAll(permutations(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, str.length()), k));
//        }
//        return results;
//    }
//
//    public Deque<Integer> toDeque(String list) {
//        return Stream.of(list).flatMapToInt(string -> {
//                    int[] ints = new int[string.length()];
//                    for (int i = 0; i < string.length(); i++)
//                        ints[i] = Integer.valueOf("" + string.charAt(i));
//                    return Arrays.stream(ints);
//                }).boxed().distinct().collect(Collectors.toCollection(ArrayDeque::new));
//    }

}
