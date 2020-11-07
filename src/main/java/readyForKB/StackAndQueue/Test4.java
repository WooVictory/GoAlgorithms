package readyForKB.StackAndQueue;

import java.util.LinkedList;

/**
 * created by victory_woo on 2020/11/06
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
    }

    /*
    * 접근 방법.
    * Truck 라는 클래스를 통해 트럭의 무게와 다리에 진입한 시간을 저장한다.
    * 먼저, q는 대기열에 있는 트럭이라고 생각하면 된다. 따라서 weight, 시작 시간은 0으로 초기화가 되어 있다.
    *
    * q와 bridges 가 모두 빌 때까지 계속해서 반복한다.
    * time++ 을 통해서 시간을 계속 흐른다.
    *
    * 먼저, bridges 를 확인하여 다리에 올라와 있는 트럭들을 확인한다.
    * 트럭은 1초에 1만큼 움직이기 때문에 현재 시간인 time 에서 트럭이 다리에 진입한 시간을 빼면 트럭이 다리를 다 지나갔는지 구할 수 있다.
    * length 보다 크거나 같다면 그 트럭은 다리를 지난 것으로 판단하여 bridges 에서 트럭을 빼고 total 무게에서 해당 트럭의 무게를 뺀다.
    * total 은 다리에 올라와 있는 트럭들 무게의 합이다.
    *
    * 다음으로는 q를 확인하여 대기열에 있는 트럭이 다리에 올라갈 수 있는지 확인하는데, 이때 total 을 사용한다.
    * total + 트럭의 무게가 트럭이 견딜 수 있는 무게 weight 보다 작거나 같다면 트럭은 다리에 올라갈 수 있다.
    * 따라서 q에서 트럭을 빼고 total 에 추가해준뒤, bridges 에 추가한다.
    * */
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        LinkedList<Truck> q = new LinkedList<>();
        LinkedList<Truck> bridges = new LinkedList<>();

        for (int w : truck_weights) {
            q.add(new Truck(w, 0));
        }

        int totalWeight = 0;
        int time = 0;
        while (!q.isEmpty() || !bridges.isEmpty()) {
            time++;

            if (!bridges.isEmpty()) {
                if (bridge_length <= time - bridges.getFirst().startTime) {
                    Truck truck = bridges.remove();
                    totalWeight = totalWeight - truck.weight;
                }
            }


            if (!q.isEmpty()) {
                if (totalWeight + q.peekFirst().weight <= weight) {
                    Truck truck = q.remove();
                    totalWeight = totalWeight + truck.weight;
                    bridges.add(new Truck(truck.weight, time));
                }
            }
        }
        return time;
    }

    static class Truck {
        int weight;
        int startTime;

        Truck(int weight, int startTime) {
            this.weight = weight;
            this.startTime = startTime;
        }
    }
}
