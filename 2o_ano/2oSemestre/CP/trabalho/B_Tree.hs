module B_Tree where

import Cp

-- (1) Datatype definition -----------------------------------------------------

data B_Tree a = Nil | Block { leftmost :: B_Tree a , block :: [(a, B_Tree a)]}
    deriving (Show , Eq )

outB_Tree :: B_Tree a -> Either () (B_Tree a , [(a, B_Tree a)]) 
outB_Tree Nil = i1 ()
outB_Tree (Block t l) = i2 (t, l)

inB_Tree  :: Either () (B_Tree a , [(a, B_Tree a)]) -> B_Tree a
inB_Tree = either (const Nil) (uncurry Block)

-- (2) Ana + cata + hylo -------------------------------------------------------

recB_Tree ::  (a -> b) -> Either () (a , [(d, a)]) -> Either () (b , [(d, b)])
recB_Tree f = id -|- (f >< (map (id >< f)))

cataB_Tree :: ((Either () (b , [(a, b)])) -> b) -> B_Tree a -> b
cataB_Tree g = g . (recB_Tree (cataB_Tree g)) . outB_Tree

anaB_Tree :: (a -> Either () (a , [(b , a)])) -> a -> B_Tree b
anaB_Tree g = inB_Tree . (recB_Tree (anaB_Tree g)) . g

hyloB_Tree :: ((Either () (c , [(b, c)])) -> c) -> (a -> Either () (a , [(b , a)])) -> a -> c
hyloB_Tree h g = cataB_Tree h . anaB_Tree g 

inordB_Tree :: B_Tree t -> [t]
inordB_Tree = cataB_Tree (either nil (conc . (id >< (concat . (map cons)))))

