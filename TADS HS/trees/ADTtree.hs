module ADTtree where

import TreeADT

data Arbol a = Nil | N (Arbol a) a (Arbol a)
    deriving (Show,Eq,Ord)

instance Tree Arbol where
    
    raiz (N hi r hd) = r
    
    --inOrder:: s a -> [a]
    inOrder Nil = []
    inOrder (N hi r hd) = inOrder(hi) ++ [r] ++ inOrder(hd)
    --preOrder:: s a -> [a]
    
    preOrder Nil = []
    preOrder (N hi r hd) = [r] ++ preOrder(hi) ++ preOrder(hd)
    --postOrder:: s a -> [a]
    
    postOrder Nil = []
    postOrder (N hi r hd) =  preOrder(hi) ++ preOrder(hd) ++ [r]
    
    --insertar :: a -> s a -> s a
    insertar n Nil = (N Nil n Nil)
    insertar n (N hi r hd) 
                          |(n > r) = (N hi r (insertar n hd))
                          |(n < r) = (N (insertar n hi) r hd)
    

    --borrar :: a -> s a -> s a
    borrar x Nil = Nil
    borrar x (N hi r hd) 
                        |(x < r) = (N (borrar x hi) r hd)
                        |(x > r) = (N  hi r (borrar x hd))
                        |(x == r) && hd /= Nil && hi == Nil = (N Nil (raiz hd) Nil)
                        |(x == r) && hd == Nil && hi /= Nil = (N Nil (raiz hi) Nil)
                        |(x == r) && hd /= Nil && hi /= Nil = (N (borrar (mayorValor hi) hi) (mayorValor hi) hd)
                        |(x == r) && hd == Nil && hi == Nil = Nil

                        


    --pertenece :: a -> s a -> Bool
    pertenece x (Nil) = False
    pertenece x (N hi r hd)
                           |(x < r) = (pertenece x hi)
                           |(x > r) = (pertenece x hd)
                           |(x == r) = True
   
    --vaciar :: s a -> s a
    vaciar (N hi r hd) = Nil
   
    --subArbolDerecho :: s a -> s a
    subArbolDerecho (N hi r hd) = hd
   
    --subArbolIzquierda :: s a -> s a 
    subArbolIzquierda (N hi r hd) = hi
   
    --elementos :: s a -> Int
    elementos (Nil) = 0
    elementos (N hi r hd) = 1 + elementos hi + elementos hd
    
    --altura ::  s a -> Int
    altura Nil = 0
    altura (N hi r hd) = 1 + max (altura hi) (altura hd)

    --esVacio :: s a -> Bool
    esVacio (Nil) = True
    
    --mayorValor :: s a -> a
    mayorValor (N Nil r Nil) = r
    mayorValor (N hi r Nil) = mayorValor hi
    mayorValor (N Nil r hd) = mayorValor hd
    mayorValor (N hi r hd) = mayorValor hd
    
    --menorValor :: s a -> a
    menorValor (N Nil r Nil) = r
    menorValor (N hi r hd) = menorValor hi
    
    --repOK :: s a -> Bool
