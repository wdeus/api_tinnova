package com.tinnova.avaliacao.domain;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Exercicio02 {

	
	public int[] bubbleSort() {
		
		int[] v = {5,3,2,4,7,1,0,6};
		int auxiliar;
		
		for(int i = 0; i < v.length; i++) {
			for(int j=0; j < v.length-1; j++) {
				if(v[j] > v[j + 1]) {
					auxiliar = v[j];
					v[j] = v[j+1];
					v[j+1] = auxiliar;
				}
			}
		}
		return v;
	}
	
	
	public static void main(String[] args) {
		Exercicio02 exer02 = new Exercicio02();
		exer02.bubbleSort();
	}
	
}
