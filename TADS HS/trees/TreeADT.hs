module TreeADT where

class Tree s where

    inOrder:: s a -> [a]
    preOrder:: s a -> [a]
    postOrder:: s a -> [a]
    insertar :: (Ord a) => a -> s a -> s a
    borrar :: (Ord a) => a -> s a -> s a
    pertenece :: (Ord a) => a -> s a -> Bool
    vaciar :: s a -> s a
    raiz :: s a -> a
    subArbolDerecho :: s a -> s a
    subArbolIzquierda :: s a -> s a 
    elementos :: s a -> Int
    altura ::  s a -> Int
    esVacio :: s a -> Bool
    mayorValor :: s a -> a
    menorValor :: s a -> a
--    repOK :: s a -> Bool
