﻿/* Димитър Валериев Трифонов, КН, 50Б, 146518 */


/*

10) Дадени са едномерните масиви a с m елемента и b с n елемента. 
Елементите им са подредени в ненамаляващ на стойностите им ред. 
Да се слеят двата масива в масив d с m+n елемента, също подреден в ненамаляващ ред.

*/


#include "stdafx.h"
using namespace std;
#include <iostream>
#include <stdlib.h>
#include <conio.h>
#include <math.h>

void main(){
	system("chcp 1251");

	int m, n, i, j, k;

	cout << "Enter m (брой елементи в 'a'): "; cin >> m;
	cout << "Enter n (брой елементи в 'b'): "; cin >> n;

	int *a = new int[m+1]; // Заделя се памет за m+1, защото в цикъла i < m+1
	int *b = new int[n+1]; // Същото за n+1 и m+n+1
	int *d = new int[m + n+1];

	cout << endl;

	for (i = 1; i < m+1; i++){
		cout << "a[" << i << "]: "; cin >> a[i];
		if (a[i - 1] > a[i]) { cout << "Елементите не са в ненамаляващ ред." << endl; return; }
	}

	cout << endl;

	for (j = 1; j < n + 1; j++){
		cout << "b[" << j << "]: "; cin >> b[j];
		if (b[j - 1] > b[j]) { cout << "Елементите не са в ненамаляващ ред." << endl; return; }
	}

	cout << endl << "Резултат: " << endl;


	for (
		i = 1, j = 1, k = 1;
		k<m + n + 1;
	k++)
	{
		if (m == n)
		{
			if (a[i] <= b[j] && i < m + 1) {
				d[k] = a[i];
				i++;
			}
			else {
				d[k] = b[j];
				j++;
			}
		}

		if (m < n)
		{
			if (a[i] <= b[j] && i < n) {
				d[k] = a[i];
				i++;
			}
			else {
				d[k] = b[j];
				j++;
			}
		}

		if (m > n)
		{
			if (a[i] > b[j] && j < m){
				d[k] = b[j];
				j++;
			}
			else {
				d[k] = a[i];
				i++;
			}
		}


		cout << "d[" << k << "]: " << d[k] << endl;
	}

	delete[]d;
	delete[]a;
	delete[]b;

	_getch();
	

	
}