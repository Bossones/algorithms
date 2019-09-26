#include <iostream>
//решение задачи связности вводимых пар
//методом быстрого поиска
int main() {
    const int N = 10;
    int i, p, q, id[N];
    for (i = 0; i < N; ++i) 
        id[i] = i;
    while (std::cin >> p >> q) {
        int t = id[p];
        if (t == id[q]) {
            std::cout << "Alredy exist" << std::endl;
            continue;
        }
        for (i = 0; i < N; ++i)
            if (id[i] == t) id[i] = id[q];
        std::cout << " " << p << " " << q << "\t";
        for (i = 0; i < N; ++i)
            std::cout << " " << id[i];
        std::cout << std::endl;
        
    }
    return 0;
}