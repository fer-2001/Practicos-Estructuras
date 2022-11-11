data Tree a = Nil | N (Tree a) a (Tree a)
    deriving (Show,Eq) 

mapTree :: (a->b) -> (Tree a) -> (Tree b)
mapTree f Nil = Nil
mapTree f (N hi r hd) = N (mapTree f hi) (f r) (mapTree f hd) 


espejo :: (Tree a) -> (Tree a)
espejo Nil = Nil
espejo (N hi r hd) = N (espejo(hd)) r (espejo(hi))


alt :: (Tree a) -> Int
alt Nil = 0
alt (N hi r hd) = 1 + max (alt hd) (alt hi)

size :: (Tree a) -> Int
size Nil = 0
size (N hi r hd) = 1 + size hi + size hd


preorder :: (Tree a) -> [a]
preorder Nil = []
preorder (N hi r hd) = r : (preorder hi ++ preorder hd)

inorder :: (Tree a) -> [a]
inorder Nil = []
inorder (N hi r hd) = (inorder hi) ++ [r] ++ (inorder hd)

posorder :: (Tree a) -> [a]
posorder Nil = []
posorder (N hi r hd) = (posorder hi) ++ (posorder hd) ++ [r]

full :: (Tree a) -> Bool
full Nil = True
full (N hi r hd) = (full hi) && (full hd) && (alt hi == alt hd)

insertar :: (Eq a) => (Tree a) -> a -> (Tree a)
insertar Nil x = (N Nil x Nil)
insertar (N hi r hd) x | hi == Nil = (N (N Nil x Nil) r hd)
                       | hd == Nil = (N hi r (N Nil x Nil)) 
                       | (hi /= Nil && (alt hi < alt hd) && ((size hi < size hd))) = (N (insertar hi x) r hd)
                       | hd /= Nil = (N hi r (insertar hd x))


pertenece :: (Eq a) => (Tree a) -> a -> Bool
pertenece Nil x = False
pertenece (N hi r hd) x = if r == x then True else (pertenece hi x) || (pertenece hd x)

-- (N (N (N (N Nil 'A' Nil) 'B' (N Nil 'C' Nil)) 'D' (N Nil 'F' (N Nil 'G' Nil) )) 'H' (N (N (N Nil 'I' Nil) 'J' (N Nil 'K' Nil)) 'L' (N Nil 'N' (N Nil 'M' Nil))))
-- (N (N Nil 2 Nil) 1 (N Nil 3 Nil))

raiz :: (Tree a) -> a
raiz (N hi r hd) = r

borrar :: (Ord a) => a -> (Tree a) -> (Tree a)
borrar x Nil = Nil
borrar x (N hi r hd) 
                    |(x < r) = (N (borrar x hi) r hd)
                    |(x > r) = (N  hi r (borrar x hd))
                    |(x == r) && hd /= Nil && hi == Nil = (N Nil (raiz hd) Nil)
                    |(x == r) && hd == Nil && hi /= Nil = (N Nil (raiz hi) Nil)
                    |(x == r) && hd /= Nil && hi /= Nil = (N (borrar (mayorValor hi) hi) (mayorValor hi) hd)
                    |(x == r) && hd == Nil && hi == Nil = Nil

mayorValor :: (Tree a) -> a
mayorValor (N Nil r Nil) = r
--mayorValor (N hi r Nil) = mayorValor hi
mayorValor (N Nil r hd) = mayorValor hd
mayorValor (N hi r hd) = mayorValor hd


rmMax :: (Ord a) => (Tree a) -> (a, Tree a)
rmMax (N hi r hd) = (mayor, (borrar mayor (N hi r hd)))
                    where mayor = mayorValor (N hi r hd)


{-
-- Retorna un par en donde: el primer elemento es el máximo del ABB 
--y el segundo es el arbol sin el maximo
rmMax :: (Ord a) => (Tree a) -> (a, Tree a)
rmMax Nil = error "Arbol vacio"
rmMax (N hi r Nil) = (r, hi)
rmMax (N hi r hd) = (m, (N hi r hd2))
                 where (m, hd2) = rmMax hd

rmMin :: (Ord a) => (Tree a) -> (a, Tree a)
rmMin Nil = error "Arbol vacio"
rmMin (N Nil r hd) = (r, hd)
rmMin (N hi r hd) = (m, (N hi2 r hd))
                 where (m, hi2) = rmMin hi
-}
-- (N (N (N Nil 20 Nil) 40 (N Nil 50 Nil)) 60 (N (Nil) 90 (N (Nil) 100 (Nil))))