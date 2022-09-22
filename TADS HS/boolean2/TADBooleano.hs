module TADBooleano where

import BooleanTad 


instance BooleanTad Integer where
    not' n = if (n==0) then 1 else 0
    or' p q = p + q
    and' p q = p * q
    true' = 1
    false' = 0
    funAbstract n = (mod n 2) == 1 