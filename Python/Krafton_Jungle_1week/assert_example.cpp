#include <iostream>
#include <cassert>
int divide(int numerator, int denominator) {
	// 분모가 0이 아니면 에러 발생
	assert(denominator != 0);
	return (double)numerator/denominator;
}

int main() {
	std::cout << divide(10, 0) << std::endl;
	return 0;
}