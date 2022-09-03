library IEEE;
use IEEE.std_logic_1164.all;

entity demux8x1 is
port (s0,s1,s2,D: in bit;  
      F0,F1,F2,F3,F4,F5,F6,F7: out bit);
end demux8x1;

architecture structure of demux8x1 is
component and4
port(X0,X1,X2,X3:in bit; O:out bit);
end component;

component inv
port (X1: in bit; O: out bit);
end component;

signal i0,i1,i2:bit;
begin
u0: inv port map (s0,i0);
u1: inv port map (s1,i1);
u2: inv port map (s2,i2);
u3: and4 port map (i2,i1,i0,D,F0);
u4: and4 port map (i2,i1,s0,D,F1);
u5: and4 port map (i2,s1,i0,D,F2);
u6: and4 port map (i2,s1,s0,D,F3);
u7: and4 port map (s2,i1,i0,D,F4);
u8: and4 port map (s2,i1,s0,D,F5);
u9: and4 port map (s2,s1,i0,D,F6);
u10: and4 port map (s2,s1,s0,D,F7);
end structure;

entity and4 is -- Πύλη AND 4 εισόδων
port(X0,X1,X2,X3: in bit; O: out bit);
end and4;

architecture behave of and4 is
begin
O<= X0 and X1 and X2 and X3;
end behave;

entity inv is -- Αντιστροφέας
  port (X1: in bit; O: out bit);
end inv;

architecture behave of inv is
begin
  O<= not X1;
end behave;
