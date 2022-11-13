
data Tree a = Nil | N (Tree a) a (Tree a)
    deriving (Show,Eq)

--raiz :: (Tree a) -> a
--raiz Nil = Nil
--raiz (N hi r hd) = r

inOrder :: (Tree a)-> [a]
inOrder Nil = []
inOrder (N Nil r Nil) = [r]
inOrder (N hi r hd) = inOrder(hi) ++ [r] ++ inOrder(hd)

preOrder:: (Tree a)-> [a]
preOrder Nil = []
preOrder (N Nil r Nil) = [r]
preOrder (N hi r hd) = [r] ++ preOrder(hi) ++ preOrder(hd)

postOrder:: (Tree a)-> [a]
postOrder Nil = []
postOrder (N Nil r Nil) = [r]
postOrder (N hi r hd) =  preOrder(hi) ++ preOrder(hd) ++ [r]

insertar :: (Ord a) =>  (Tree a) -> a -> (Tree a)
insertar Nil n = (N Nil n Nil)
insertar (N hi r hd) n 
                       |(n > r) = (insertar hd n)
                       |(n < r) = (insertar hi n)
--insertar (N hi r hd) n = if (n > r) then (insertar hd n)
--insertar (N hi r hd) n = if (n < r) then (insertar hi n)

pertenece :: (Ord a) => a -> (Tree a) -> Bool
pertenece x (Nil) = False
pertenece x (N hi r hd) 
                        |(x < r) = (pertenece x hi)
                        |(x > r) = (pertenece x hd)
                        |(x == r) = True
--pertenece x (N hi r hd) = if (x < r) then (pertenece x hi)
--pertenece x (N hi r hd) = if (x > r) then (pertenece x hd)
--pertenece x (N hi r hd) = if (x == r) then True

vaciar :: (Tree a) -> (Tree a)
vaciar (N hi r hd) = Nil

subArbolDerecho :: (Tree a) -> (Tree a)
subArbolDerecho (N hi r hd) = hd

subArbolIzquierda :: (Tree a)-> (Tree a) 
subArbolIzquierda (N hi r hd) = hi

elementos :: (Tree a) -> Int
elementos (Nil) = 0
elementos (N hi r hd) = 1 + elementos hi + elementos hd

esVacio :: (Tree a) -> Bool
esVacio (Nil) = True

mayorValor :: (Tree a) -> a
mayorValor (N Nil r Nil) = r
mayorValor (N hi r hd) = mayorValor hd

menorValor :: (Tree a) -> a
menorValor (N Nil r Nil) = r
menorValor (N hi r hd) = menorValor hi

sorted :: (Ord a) => [a] -> Bool
sorted [] = True
sorted [x] = True
sorted (x:(y:xs)) = x <= y && sorted(y:xs)

repOK :: (Ord a) => (Tree a) -> Bool
repOK t@(N hi r hd) = sorted(inOrder((t)))


