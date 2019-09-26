#include <iostream>
//решение задачи связности двух вводимых пар
//методом быстрого объединения
int main() {
    const int N = 10;
    int id[N], i, j, p, q;
    for (i = 0; i < N; ++i) id[i] = i;
    while (std::cin >> p >> q) {
        for (i = p; i != id[i]; i = id[i]);
        for (j = q; j != id[j]; j = id[j]);
        if (i == j) {
            std::cout << "Alredy exist" << std::endl;
            continue;
        }
        id[i] = j;
        std::cout << " " << p << " " << q << "\t";
        for (i = 0; i < N; ++i)
            std::cout << " " << id[i];
        std::cout << std::endl;
    }
    return 0;
}