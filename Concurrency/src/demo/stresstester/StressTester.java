package demo.stresstester;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StressTester {

	public static void main(String[] args) throws InterruptedException {

		// Server server = new Server();
		final Collection<String> hetuList = Arrays.asList("160375-7476", "070175-685S", "300180-741P", "050150-263D",
				"010852-131R", "071052-0675", "070252-7967", "170174-1379");

		int nThreads = 20;

		ExecutorService es = Executors.newFixedThreadPool(nThreads);
		final CyclicBarrier barrier = new CyclicBarrier(nThreads);
		for (int i = 0; i < nThreads; i++) {
			es.submit(() -> {
				try {
					barrier.await();
					for (int i1 = 0; i1 < 100000; i1++) {
						hetuList.stream().forEach((String hetu) -> {
							try {
								System.out.println("Do something with hetu " + hetu);
							} catch (RuntimeException re) {
								re.printStackTrace();
								System.exit(-1);
							}
						});
					}
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			});
		}

		es.shutdown();
		es.awaitTermination(20, TimeUnit.SECONDS);
	}
}
