
module BooleanTad where

class BooleanTad s where 
    not' :: s -> s
    or' :: s -> s -> s
    and' :: s -> s -> s
    true' :: s
    false' :: s
    funAbstract :: s -> Bool 