import Cp

data Atl
data Jog
data Dat

f :: [(Dat, [Jog])] -> [(Jog,[Atl])] -> [(Atl,[Dat])]
f = undefined

collect ::[(a,b)] -> [(a,[b])]
collect = undefined

discollect ::[(a,[b])] -> [(a,b)]
discollect = undefined

converse ::[(a,b)] -> [(b,a)]
converse = undefined

comp :: [(a,b)] -> [(b,c)] -> [(a,c)]
comp = undefined

sort :: [a] -> [a]
sort = undefined
