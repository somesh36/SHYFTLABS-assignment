package solutions;

public class Chess {
    public abstract class Piece {
        private boolean isWhite;

        public Piece(boolean isWhite) {
            this.isWhite = isWhite;
        }

        public boolean isWhite() {
            return this.isWhite;
        }

        public abstract boolean canMove(int sourceX, int sourceY, int destX, int destY);
    }

    public class Pawn extends Piece {
        public Pawn(boolean isWhite) {
            super(isWhite);
        }

        @Override
        public boolean canMove(int sourceX, int sourceY, int destX, int destY) {
            
            if (isWhite()) {
                return destX == sourceX && destY == sourceY + 1;
            } else {
                return destX == sourceX && destY == sourceY - 1;
            }
        }
    }

    public class Rook extends Piece {
        public Rook(boolean isWhite) {
            super(isWhite);
        }

        @Override
        public boolean canMove(int sourceX, int sourceY, int destX, int destY) {
           
            return sourceX == destX || sourceY == destY;
        }
    }

    public class Knight extends Piece {
        public Knight(boolean isWhite) {
            super(isWhite);
        }

        @Override
        public boolean canMove(int sourceX, int sourceY, int destX, int destY) {
           
            return (Math.abs(sourceX - destX) == 2 && Math.abs(sourceY - destY) == 1) || (Math.abs(sourceX - destX) == 1 && Math.abs(sourceY - destY) == 2);
        }
    }

    public class Bishop extends Piece {
        public Bishop(boolean isWhite) {
            super(isWhite);
        }

        @Override
        public boolean canMove(int sourceX, int sourceY, int destX, int destY) {
           
            return Math.abs(sourceX - destX) == Math.abs(sourceY - destY);
        }
    }

    public class Queen extends Piece {
        public Queen(boolean isWhite) {
            super(isWhite);
        }

        @Override
        public boolean canMove(int sourceX, int sourceY, int destX, int destY) {
           
            return sourceX == destX || sourceY == destY || Math.abs(sourceX - destX) == Math.abs(sourceY - destY);
        }
    }

    public class King extends Piece {
        public King(boolean isWhite) {
            super(isWhite);
        }

        @Override
        public boolean canMove(int sourceX, int sourceY, int destX, int destY) {
            
            return Math.abs(sourceX - destX) <= 1 && Math.abs(sourceY - destY) <= 1;
        }
    }

    public class Spot {
        private Piece piece;
        private int x;
        private int y;

        public Spot(int x, int y, Piece piece) {
            this.piece = piece;
            this.x = x;
            this.y = y;
        }

        public Piece getPiece() {
            return this.piece;
        }

        public int getX() {
            return this.x;
        }

        public int getY() {
            return this.y;
        }
    }
    public static void main(String[] args) {
        Chess chess = new Chess();

        Pawn whitePawn = chess.new Pawn(true);
        Pawn blackPawn = chess.new Pawn(false);
        Rook whiteRook = chess.new Rook(true);

        System.out.println("White pawn can move to (0,1): " + whitePawn.canMove(0, 0, 0, 1));
        System.out.println("Black pawn can move to (0,1): " + blackPawn.canMove(0, 0, 0, 1));
        System.out.println("White rook can move to (0,1): " + whiteRook.canMove(0, 0, 0, 1));
}
}