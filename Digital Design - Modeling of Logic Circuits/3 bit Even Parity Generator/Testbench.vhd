library IEEE;
use IEEE.std_logic_1164.all;

entity test_ParityGenenerator is
end test_ParityGenenerator;

architecture testbench of test_ParityGenenerator is
  component ParityGenenerator
    port(A,B,C: in bit; X: inout bit; P: out bit);
  end component;
signal tb_A: bit;
signal tb_B: bit;
signal tb_C: bit;
signal tb_P: bit;

begin
u0: ParityGenenerator port map(
    A => tb_A,
    B => tb_B,
    C => tb_C,
    P => tb_P);
process
  begin
  tb_C <= '0' ;
  tb_B <= '0' ;
  tb_A <= '0' ;
  wait for 10 ns;

  tb_C <= '1' ;
  tb_B <= '0' ;
  tb_A <= '0' ;
  wait for 10 ns;

  tb_C <= '0' ;
  tb_B <= '1' ;
  tb_A <= '0' ;
  wait for 10 ns;

  tb_C <= '1' ;
  tb_B <= '1' ;
  tb_A <= '0' ;
  wait for 10 ns;

  tb_C <= '0' ;
  tb_B <= '0' ;
  tb_A <= '1' ;
  wait for 10 ns;

  tb_C <= '1' ;
  tb_B <= '0' ;
  tb_A <= '1' ;
  wait for 10 ns;

  tb_C <= '0' ;
  tb_B <= '1' ;
  tb_A <= '1' ;
  wait for 10 ns;

  tb_C <= '1' ;
  tb_B <= '1' ;
  tb_A <= '1' ;
  wait for 10 ns;

  end process;
end testbench;

