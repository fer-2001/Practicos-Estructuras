-- Autor: Manuel Fernandez
module ConjutosADT where
import TadConjuntos 
-- Implementacion del tipo abstracto de datos Conjuntos
instance Conjuntos [] where
    vacia = []
    ins x [] = [x]
    ins x (y:ys) | (x == y) = (y:ys)
                 | (x < y) = x:(y:ys)
                 | (x > y) = y:(ins x ys)
    union xs [] = xs
    union [] ys = ys
    union xs (y:ys) =  union (ins y xs) ys 
    pertenece x [] = False
    pertenece x (y:ys) = (x == y) || (pertenece x ys)
