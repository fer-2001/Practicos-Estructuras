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