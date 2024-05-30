package com.computationalalgorithms;

import java.util.*;

public class JobSequencing {
	static class Job{
		int Id;
		int Deadline;
		int Profit;
		public Job(int Id, int Deadline, int Profit) {
			this.Id = Id;
			this.Deadline = Deadline;
			this.Profit = Profit;
		}
	}
	public static List<Job> jobSequencing(List<Job> jobs){
		jobs.sort((a, b) -> b.Profit - a.Profit);
		int maxDeadline = jobs.stream().max(Comparator.comparingInt(job -> job.Deadline)).get().Deadline;
		Job[] result = new Job[maxDeadline];
		boolean[] slot = new boolean[maxDeadline];
		for(Job job : jobs) {
			for(int j = Math.min(maxDeadline - 1, job.Deadline - 1); j >= 0; j--) {
				if(!slot[j]) {
					slot[j] = true;
					result[j] = job;
					break;
				}
			}
		}
		List<Job> jobSequence = new ArrayList<>();
		for(Job job : result) {
			if(job!=null) {
				jobSequence.add(job);
			}
		}
		return jobSequence;
	}

	public static void main(String[] args) {
		List<Job> jobs = Arrays.asList(
				new Job(1,2,100),
				new Job(2,1,19),
				new Job(3,2,27),
				new Job(4,1,25),
				new Job(5,3,15)
				);
		List<Job> jobSequence = jobSequencing(jobs);
		System.out.println("Selected jobs for maximum profit:");
		for(Job job : jobSequence) {
			System.out.println("Job ID: " + job.Id + " , Deadline: " + job.Deadline + " , Profit " + job.Profit);
		}

	}

}
