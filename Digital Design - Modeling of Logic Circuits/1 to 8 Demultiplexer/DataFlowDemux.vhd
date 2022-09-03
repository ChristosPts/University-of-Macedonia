library IEEE;
use IEEE.std_logic_1164.all;

entity demux8x1 is
port (s0,s1,s2,D: in bit;  
      F0,F1,F2,F3,F4,F5,F6,F7: out bit);
end demux8x1;     

architecture dataflow of demux8x1 is

begin
   F0 <= not(s2)and not(s1)and not(s0)and D;
   F1 <= not(s2)and not(s1)and s0 and D;
   F2 <= not(s2)and s1 and not(s0)and D;
   F3 <= not(s2)and s1 and s0 and D;
   F4 <= s2 and not(s1)and not(s0)and D;
   F5 <= s2 and not(s1)and s0 and D;
   F6 <= s2 and s1 and not(s0)and D;
   F7 <= s2 and s1 and s0 and D;
end dataflow;

